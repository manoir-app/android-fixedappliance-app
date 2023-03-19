package app.manoir.fixedappliances

import android.content.Context
import android.content.RestrictionsManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import app.manoir.fixedappliances.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)

        windowInsetsController?.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        windowInsetsController?.hide(WindowInsetsCompat.Type.systemBars())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var b = binding.webView;
        b.settings.javaScriptEnabled = true;
        b.settings.builtInZoomControls = false;
        b.settings.useWideViewPort = false;

        b.webViewClient = ManoirWebViewClient();

        var url = getRootUrl();
        b.loadUrl(url);
    }

    private fun getRootUrl(): String {
        var url = "https://home.anzin.carbenay.manoir.app/devicehome/";
        var restrictionManager =
            this.getSystemService(RESTRICTIONS_SERVICE) as RestrictionsManager;
        var config = restrictionManager.applicationRestrictions;
        if (config != null) {
            if (config.containsKey("rootUrl")) {
                val tmp = config.getString("rootUrl");
                if (tmp != null)
                    url = tmp;
                if (!url.endsWith(("/")))
                    url = url + "/";
                if (!url.endsWith("/devicehome/"))
                    url = url + "devicehome/";
            }
        }
        return url
    }
}
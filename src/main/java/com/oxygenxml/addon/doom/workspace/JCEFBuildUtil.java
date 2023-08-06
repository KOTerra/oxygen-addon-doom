package com.oxygenxml.addon.doom.workspace;

import java.io.IOException;

import org.cef.CefApp;
import org.cef.CefApp.CefAppState;

import me.friwi.jcefmaven.CefAppBuilder;
import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.MavenCefAppHandlerAdapter;
import me.friwi.jcefmaven.UnsupportedPlatformException;

public abstract class JCEFBuildUtil {
	public static CefApp buildJCEF(CefAppBuilder builder)
			throws IOException, UnsupportedPlatformException, InterruptedException, CefInitializationException {
		// (0) Initialize CEF using the maven loader
		// windowless_rendering_enabled must be set to false if not wanted.
		builder.getCefSettings().windowless_rendering_enabled = false;
		// USE builder.setAppHandler INSTEAD OF CefApp.addAppHandler!
		// Fixes compatibility issues with MacOSX
		builder.setAppHandler(new MavenCefAppHandlerAdapter() {
			@Override
			public void stateHasChanged(org.cef.CefApp.CefAppState state) {
				// Shutdown the app if the native CEF part is terminated
				if (state == CefAppState.TERMINATED)
					System.exit(0);
			}
		});

		return builder.build();
	}

}

package com.oxygenxml.addon.doom.workspace;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.CefSettings;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefMessageRouter;

import ro.sync.exml.plugin.workspace.WorkspaceAccessPluginExtension;
import ro.sync.exml.workspace.api.standalone.StandalonePluginWorkspace;

/**
 * Plugin extension - workspace access extension.
 */
public class CustomWorkspaceAccessPluginExtension implements WorkspaceAccessPluginExtension {

  public void applicationStarted(final StandalonePluginWorkspace pluginWorkspaceAccess) {
    pluginWorkspaceAccess.addViewComponentCustomizer(viewInfo -> {

      JPanel panel = new JPanel();

      CefSettings settings = new CefSettings();
      settings.windowless_rendering_enabled = false;
      CefApp cefApp = CefApp.getInstance(settings);
      CefClient client = cefApp.createClient();
      client.addMessageRouter(CefMessageRouter.create());
      CefBrowser browser = client.createBrowser("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley",
          false, false);
      JTextField address = new JTextField("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
      address.addActionListener(e -> browser.loadURL(address.getText()));

      panel.add(browser.getUIComponent(), BorderLayout.CENTER);
      panel.add(address, BorderLayout.SOUTH);
      panel.setVisible(true);
      viewInfo.setComponent(panel);

      viewInfo.setComponent(panel);

    });
  }

  public boolean applicationClosing() {
    // You can reject the application closing here
    return true;
  }
}
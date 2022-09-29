package com.oxygenxml.addon.doom.workspace;

import ro.sync.exml.plugin.workspace.WorkspaceAccessPluginExtension;
import ro.sync.exml.workspace.api.standalone.StandalonePluginWorkspace;

/**
 * Plugin extension - workspace access extension.
 */
public class CustomWorkspaceAccessPluginExtension implements WorkspaceAccessPluginExtension {

  public void applicationStarted(final StandalonePluginWorkspace pluginWorkspaceAccess) {
  }

 

  public boolean applicationClosing() {
    // You can reject the application closing here
    return true;
  }
}
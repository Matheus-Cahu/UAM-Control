package com.exemplo;

import org.jxmapviewer.viewer.TileFactoryInfo;
public class OSMTileFactoryInfo extends TileFactoryInfo
{
  public OSMTileFactoryInfo() {
    super("OpenStreetMap", 1, 19, 20, 256, true, true, "https://tile.openstreetmap.org",
          "x", "y", "z"); // Repare: minZoom=1! 
  }
  @Override
  public String getTileUrl(int x, int y, int zoom) {
    int z = 20 - zoom;
    System.out.println(z + "/" + x + "/" + y);
    return this.baseURL + "/" + z + "/" + x + "/" + y + ".png";
  }
}

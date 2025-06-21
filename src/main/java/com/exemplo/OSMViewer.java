package com.exemplo;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.TileFactory;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.MouseInputListener;

public class OSMViewer {


  public static void main(String[] args)
  {

    JFrame frame = new JFrame("OSMViewer");
    JXMapViewer mapViewer = new JXMapViewer();
MouseInputListener mia = new PanMouseInputListener(mapViewer);
mapViewer.addMouseListener(mia);
mapViewer.addMouseMotionListener(mia);
mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer));
mapViewer.addMouseListener(new CenterMapListener(mapViewer));
    TileFactoryInfo info = new OSMTileFactoryInfo();
    DefaultTileFactory tileFactory = new DefaultTileFactory(info);
    mapViewer.setTileFactory(tileFactory);

    GeoPosition pos = new GeoPosition(-23.5505, -46.6333);
    mapViewer.setAddressLocation(pos);


    frame.add(mapViewer);
    frame.setSize(1920,1080);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

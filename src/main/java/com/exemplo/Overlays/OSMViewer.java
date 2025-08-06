package com.exemplo;

import com.exemplo.Elements.*;
import com.exemplo.Waypoints.*;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;

public class OSMViewer extends JPanel{

  private JXMapViewer mapViewer;

  public OSMViewer(){
    setLayout(new BorderLayout());

    mapViewer = new JXMapViewer();

    MouseInputListener mia = new PanMouseInputListener(mapViewer);
    mapViewer.addMouseListener(mia);
    mapViewer.addMouseMotionListener(mia);
    mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer));
    mapViewer.addMouseListener(new CenterMapListener(mapViewer));
    TileFactoryInfo info = new OSMTileFactoryInfo();
    DefaultTileFactory tileFactory = new DefaultTileFactory(info);
    mapViewer.setTileFactory(tileFactory);

    //Waypoints dos eVTOLs
List<Evtol> evtols = Arrays.asList(
    new Evtol("E001", -23.550, -46.6333, 100),
    new Evtol("E002", -23.551, -46.6340, 120),
    new Evtol("E003", -23.552, -46.6350, 110),
    new Evtol("E004", -23.553, -46.6360, 105),
    new Evtol("E005", -23.554, -46.6370, 115)
);
    Set<Waypoint> waypoints = new HashSet<>();
    for(Evtol e:evtols){
      waypoints.add(new EvtolWaypoint(e));
    }

    WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
    waypointPainter.setWaypoints(waypoints);

    mapViewer.setOverlayPainter(waypointPainter);

    //Posição inicial em São Paulo (Sé)
    GeoPosition pos = new GeoPosition(-23.5505, -46.6333);
    mapViewer.setAddressLocation(pos);
    add(mapViewer);
  }
    public JXMapViewer getMapViewer(){
      return this.mapViewer;
    }
}

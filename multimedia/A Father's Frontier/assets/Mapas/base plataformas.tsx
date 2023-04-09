<?xml version="1.0" encoding="UTF-8"?>
<tileset version="1.8" tiledversion="1.8.4" name="tiles23" tilewidth="18" tileheight="18" spacing="2" tilecount="180" columns="20">
 <image source="images/tiles23.png" width="398" height="178"/>
 <tile id="43">
  <objectgroup draworder="index" id="2">
   <object id="1" x="9.5477" y="9.39967"/>
   <object id="2" x="1.03618" y="2.29441" width="8.73355" height="8.65954"/>
  </objectgroup>
 </tile>
 <tile id="144">
  <properties>
   <property name="enemigo" value="mosca"/>
  </properties>
 </tile>
 <tile id="145">
  <properties>
   <property name="enemigo" value="blob"/>
  </properties>
 </tile>
 <wangsets>
  <wangset name="Plataformas" type="mixed" tile="-1">
   <wangcolor name="Plataforma cesped" color="#00ff00" tile="-1" probability="1"/>
   <wangcolor name="Plataforma nieve" color="#aaffff" tile="-1" probability="1"/>
   <wangcolor name="Plataforma rocosa" color="#844737" tile="-1" probability="1"/>
   <wangtile tileid="4" wangid="1,1,1,0,1,1,1,1"/>
   <wangtile tileid="5" wangid="1,1,1,1,1,0,1,1"/>
   <wangtile tileid="21" wangid="0,0,1,1,1,0,0,0"/>
   <wangtile tileid="22" wangid="0,0,1,1,1,1,1,0"/>
   <wangtile tileid="23" wangid="0,0,0,0,1,1,1,0"/>
   <wangtile tileid="24" wangid="1,0,1,1,1,1,1,1"/>
   <wangtile tileid="25" wangid="1,1,1,1,1,1,1,0"/>
   <wangtile tileid="48" wangid="0,0,3,0,0,0,0,0"/>
   <wangtile tileid="49" wangid="0,0,3,0,0,0,3,0"/>
   <wangtile tileid="50" wangid="0,0,0,0,0,0,3,0"/>
   <wangtile tileid="121" wangid="1,1,1,1,1,0,0,0"/>
   <wangtile tileid="122" wangid="1,1,1,1,1,1,1,1"/>
   <wangtile tileid="123" wangid="1,0,0,0,1,1,1,1"/>
   <wangtile tileid="141" wangid="1,1,1,0,0,0,0,0"/>
   <wangtile tileid="142" wangid="1,1,1,0,0,0,1,1"/>
   <wangtile tileid="143" wangid="1,0,0,0,0,0,1,1"/>
  </wangset>
 </wangsets>
</tileset>

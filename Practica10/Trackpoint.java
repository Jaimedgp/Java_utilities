import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * Clase preparada para manejar trackpoints de una ruta GPS
 */
public class Trackpoint {

    private double latitud; // Latitud, en grados
    private double longitud; // Longitud, en grados
    private double elevacion; // Elevacion, en metros
    private Date fecha; // Fecha y hora, como objeto de la clase Date

    /** 
     * Constructor al que se pasan la latitud y longitud, en grados, la
     * elevacion, en metros, y la fecha y hora, como un String con el 
     * formato de este ejemplo: "2013-11-04T16:35:03Z"
     * Si hay error en el formato, fija la fecha a "1970-01-01T01:00:00Z"
     * 
     * @param latitud    latitud, en grados
     * @param longitud   longitud, en grados
     * @param elevacion  elevacion, en metros
     * @param fecha      fecha y hora, con formato tipo "2013-11-04T16:35:03Z"
     */
    public Trackpoint(double latitud, double longitud, 
		      double elevacion, String fecha) 
    {
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion = elevacion;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            this.fecha = df.parse(fecha);
        } catch(Exception e) {
            this.fecha = new Date(0);
        }
    }

    /**
     * Metodo observador que retorna la latitud, en grados 
     * 
     * @ return latitud, en grados
     */
    public double latitud() {
        return latitud;
    }

    /**
     * Metodo observador que retorna la longitud, en grados 
     * 
     * @ return longitud, en grados
     */
    public double longitud() {
        return longitud;
    }

    /**
     * Metodo observador que retorna la elevacion, en metros 
     * 
     * @return elevacion, en metros
     */
    public double elevacion() {
        return elevacion;
    }

    /**
     * Retorna la la fecha y hora, como los milisegundos 
     * transcurridos desde 01-01-1970 
     * 
     * @return milisegundos transcurridos desde 01-01-1970
     */
    public long epoch() {
        try {
            return fecha.getTime();
        } catch(Exception e) {
            return 0;
        }
    }

    /**
     * Retorna la fecha del trackpoint como String
     * 
     * @return fecha, en formato "dd/MM/yyyy"
     */
    public String fecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    /**
     * Retorna la hora del trackpoint como String
     * 
     * @return hora, en formato "HH:mm:ss"
     */
    public String hora() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(fecha);
    }

    /**
     * Retorna la distancia, en metros, con otro Trackpoint que
     * se pasa como argumento
     * 
     * @param p  Trackpoint al que se calcula la distancia
     * @return   distancia al Trackpoint pasado como argumento
     */
    public double distancia(Trackpoint p) {
        final double R = 6371000;
        double lat1 = Math.toRadians(latitud);
        double long1 = Math.toRadians(longitud);
        double lat2 = Math.toRadians(p.latitud());
        double long2 = Math.toRadians(p.longitud());
        double sinLat2 = Math.pow(Math.sin((lat2-lat1)/2),2);
        double sinLong2 = Math.pow(Math.sin((long2-long1)/2),2);
        return 2*R*Math.asin(Math.sqrt(sinLat2+Math.cos(lat1)*
				       Math.cos(lat2)*sinLong2));
    }

    /**
     * Retorna el tiempo transcurrido, en segundos, desde otro
     * Trackpoint que se pasa como argumento
     * 
     * @param p  Trackpoint al que se calcula la distancia temporal
     * @return   tiempo transcurrido, en segundos, desde otro 
     *           Trackpoint pasado como argumento
     */
    public double tiempo(Trackpoint p) {
        return (epoch()-p.epoch())/1000;
    }

    /**
     * Retorna un ArrayList de Trackpoints que se lee de
     * un fichero GPX, cuyo nombre se pasa como argumento
     * 
     * @param fichero   nombre del fichero que guarda la ruta GPX
     * @return  lista de Trackpoints contenidos en el fichero 
     *          cuyo nombre se pasa como argumento
     */
    public static ArrayList<Trackpoint> parseGpx(String fichero) {
        ArrayList<Trackpoint> lista = new ArrayList<Trackpoint>();
        try {
            File fXmlFile = new File(fichero);
            DocumentBuilderFactory dbFactory = 
		DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("trkpt");
            for (int i=0;i<nList.getLength();i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    double lat = 
			Double.parseDouble(eElement.getAttribute("lat"));
                    double lon = 
			Double.parseDouble(eElement.getAttribute("lon"));
                    double elev = 0;
                    String time = "";
                    if (eElement.getElementsByTagName("ele").item(0)!=null){
                        elev = Double.parseDouble
			    (eElement.getElementsByTagName("ele").item(0).
			     getTextContent());
                    }
                    if (eElement.getElementsByTagName("time").item(0)!=null){
                        time = eElement.getElementsByTagName("time").item(0).
			    getTextContent();
                    }
                    lista.add(new Trackpoint(lat,lon,elev,time));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
        return lista;
    }
}

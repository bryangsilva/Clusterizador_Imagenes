/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import objetos.Patron;

/**
 *
 * @author Roberto Cruz Leija
 */
public class IOImage {
    static ArrayList<Patron> instancias = new ArrayList<>();
    static BufferedImage bfi;
    public  Image abrirImagen(){
     
        try {
            // definir los fltros de los tipos de imagenes
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Imagenes","png","jpg","bmp");
            // declarar e inicializar la venta de seleccion
            JFileChooser seleccion = new JFileChooser();
            seleccion.addChoosableFileFilter(filtro);
            // especificamos que solo puede abrir archivos
            seleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            // ejecutar el selector de archivos
            int resutlado = seleccion.showOpenDialog(null);
            // si el evento fue cancelar
            if (resutlado== JFileChooser.CANCEL_OPTION){
                return null;
            }
            File archivo = seleccion.getSelectedFile();
            bfi = ImageIO.read(archivo);
      //      Vector vector = new Vector();
//            Color color = new Color(bfi.getRGB(250, 280)) ;
   //         int red = color.getRed();
   //         int green = color.getGreen();
   //         int blue = color.getBlue();
            Color rosa = new Color(251,1,150);
          
            ArrayList reg = new ArrayList<>();
 //se obtiene los pixeles y guardas como instancia junto en su posicion en x,y
            for(int x=0; x<bfi.getWidth();x++)
                for(int y=0; y<bfi.getHeight();y++){
                    Patron p = new Patron(1);
//                    double[] v={bfi.getRGB(x, y)};
  //                  p.setVector(v);
					Color t = new Color(bfi.getRGB(x, y));
					double[] s ={t.getRed(),t.getGreen(),t.getBlue()};
                    p.setVector(s);
					p.setX(x);
                    p.setY(y);
                    instancias.add(p);
                }
            
          return bfi.getScaledInstance(bfi.getWidth(),bfi.getHeight(),BufferedImage.TYPE_INT_RGB);
        } catch (IOException ex) {
            Logger.getLogger(IOImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public void guardarImagen(Image imagen) throws IOException{
        // convertimos a buffered
        BufferedImage bi = ImageType.toBufferedImage(imagen);
        // declaramos la ventana para seleccionar la ruta 
        JFileChooser ventana = new JFileChooser();
        int res = ventana.showSaveDialog(null);
        if (res == JFileChooser.APPROVE_OPTION){
           File archivo = ventana.getSelectedFile();
           ImageIO.write(bi,"jpg", archivo);
        }
          
    }

    public ArrayList<Patron> getInstancias() {
        return instancias;
    }

	public BufferedImage getBfi() {
		return bfi;
	}
	//metodo para escalar la imagen en el label 
	public Image getScaledImage(Image srcImg, int w, int h){
		if(bfi.getHeight() >= 1080 && bfi.getWidth() >= 1920 && bfi.getHeight() >= 920 && bfi.getWidth() >= 1600){
		
			BufferedImage resizedImg = new BufferedImage(bfi.getWidth()/4, bfi.getHeight()/4, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = resizedImg.createGraphics();

			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.drawImage(srcImg, 0, 0, bfi.getWidth()/4, bfi.getHeight()/4, null);
			g2.dispose();
			return resizedImg;
		}else{
			BufferedImage resizedImg = new BufferedImage(bfi.getWidth()/2, bfi.getHeight()/2, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = resizedImg.createGraphics();

			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.drawImage(srcImg, 0, 0, bfi.getWidth()/2, bfi.getHeight()/2, null);
			g2.dispose();
			return resizedImg;
		}

	}


    
}

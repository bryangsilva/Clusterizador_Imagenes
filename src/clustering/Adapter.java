/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering;

import static clustering.IOImage.bfi;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import objetos.Patron;

/**
 *
 * @author yohovani
 */
public class Adapter {
	
	public static Image constriurNuevaImagen(ArrayList<Patron> instancias,BufferedImage bfi){
		//recorre todas las instancias y obtiene el rgb 3
		for(int i=0;i<instancias.size();i++){
			bfi.setRGB(instancias.get(i).getX(), instancias.get(i).getY(),  instancias.get(i).obtenerRGB());
		}
		return bfi.getScaledInstance(bfi.getWidth(),bfi.getHeight(),BufferedImage.TYPE_INT_RGB);
	}
	
}

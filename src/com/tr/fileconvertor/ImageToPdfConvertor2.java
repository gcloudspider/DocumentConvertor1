package com.tr.fileconvertor;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;

/**
 * @author vishwajeet kumar
 * @date 06/20/2016--NOT IN USE.
 */
public class ImageToPdfConvertor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		selectImage();

	}
	
	 public static void selectImage(){

		  //JFileChooser chooser = new JFileChooser();
		     // FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "gif","png","bmp");
		     // chooser.setFileFilter(filter);
		     // chooser.setMultiSelectionEnabled(true);
		     // int returnVal = chooser.showOpenDialog(null);
		     // if(returnVal == JFileChooser.APPROVE_OPTION) {
		          File[] Files = new File[]{new File("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/App_Error_SubmitApplication_One_Day_Pass.png")};
		          System.out.println("Please wait...");
		               for( int i=0;i<Files.length;i++){     
		                convertJPGToPDF(Files[i].toString(),"C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/pdfimage"+i+".pdf");
		                }
		        System.out.println("Conversion complete");
		          // }
		  }
	 
	 public static void convertJPGToPDF(String strimg,String desc){
		 try{
		  //create document object
		  Document doc=new Document();
		  //create pdf writer object to write the document to the output file
		  PdfWriter.getInstance(doc,new FileOutputStream(desc));
		  //get a4 paper size
		  Rectangle r=PageSize.A4;
		  //read the image
		  BufferedImage orImg=ImageIO.read(new File(strimg));
		  //initialize image width and height
		  int width=orImg.getWidth();
		  int height=orImg.getHeight();
		  //resize the image that is bigger than A4 size
		  if(width>r.getWidth())
		   width=(int)r.getWidth();
		  if(height>r.getHeight())
		   height=(int)r.getHeight();  
		  //create a blank buffered image
		  BufferedImage bi=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		  //create graphic2d object from the buffered image
		  Graphics2D g2d=bi.createGraphics();
		  //draw the original image on the buffered image
		  //so the image is resized to fit the A4 paper size if it is bigger than A4 size
		  g2d.drawImage(orImg, 0,0,width,height,null);
		  //store the image data in memory
		  ByteArrayOutputStream bas=new ByteArrayOutputStream();
		  ImageIO.write(bi, "png", bas);
		  //create image from the image data stored in memory
		  Image img=Image.getInstance(bas.toByteArray());
		  //centrally align the image on the pdf page
		  img.setAlignment(Element.ALIGN_CENTER);
		  //open document
		  doc.open();
		//add image to the document
		  doc.add(img);
		  //close the document
		  doc.close();
		  
		  
		  }catch(Exception e){e.printStackTrace();}
		 }


}

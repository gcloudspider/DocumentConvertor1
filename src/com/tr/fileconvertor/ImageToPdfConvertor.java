package com.tr.fileconvertor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

/**
 * @author vishwajeet kumar
 * @date 06/20/2016
 * @description File conversion tested with :  .PNG,.JPG,.JPEG,.GIF,.BMP.
 */

public class ImageToPdfConvertor {	
	
	
	public static void doConvert(List<String> filePaths, OutputStream outStream) throws Exception {
		
		Document document = new Document(PageSize.A4,20, 20, 20, 20);
		Rectangle r = PageSize.A4;
		float height = r.getHeight(); 
		float width = r.getWidth();
		//InputStream iStream = inStream;
		PdfWriter writer = PdfWriter.getInstance(document, outStream);
		
		writer.open();
	      document.open();
	      for(String filePath : filePaths){
	    	  Image img = Image.getInstance(filePath);
	    	 // if(img.isJpeg()){
	    		  float imgH = img.getWidth();
	    		  float imgW = img.getHeight();
	    		  if(imgH > height)
	    			  img.scaleAbsoluteHeight(height);
	    		  if(imgW > width)
	    			  img.scaleAbsoluteWidth(width);
	    		  
	    		  img.setAlignment(Element.ALIGN_CENTER);
	    		  
		    	  document.add(img);
	    	//  }
	    	  
	      }
	      writer.flush();
	      document.close();
	      writer.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<String>();
        try {
            // Source imgs
            list.add("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/App_Error_SubmitApplication_One_Day_Pass.png");
            list.add("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/slf4j-migrator.gif");
            list.add("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/jazoon09.gif");
            list.add("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/buyDirect.jpg");
            list.add("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/devoxx09.jpeg");
            //list.add("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/sticky.tif");
            list.add("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/splash.bmp");
            // Resulting pdf
            OutputStream out = new FileOutputStream(new File("C:/Users/Vishwajeet.Kumar/Desktop/DocTOPDF/ImageConvert.pdf"));

            try {
				doConvert(list, out);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

	}

}

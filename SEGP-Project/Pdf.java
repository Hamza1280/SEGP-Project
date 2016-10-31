import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf {
	public Database d;
	public void pdf(String table,String fname){
		d=new Database();
		d.numrows(table);
		d.Search(table,"random");
		int counter=d.count;
		System.out.println(d.count);
		Document doc=new Document();
		if(table=="students"){
		try {
			PdfWriter.getInstance(doc,new FileOutputStream(fname));
			doc.open();
			PdfPTable pdftable=new PdfPTable(7);
			for(int row=0;row<counter;row++){
				for(int col=0;col<7;col++){
					System.out.println("loop");
					System.out.println(d.data[row][col]);
					pdftable.addCell(d.data[row][col]);
				}
			}
			doc.add(pdftable);
			doc.close();
			System.out.println("done");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if(table=="pats"){
			try {
				PdfWriter.getInstance(doc,new FileOutputStream(fname));
				doc.open();
				PdfPTable pdftable=new PdfPTable(4);
				for(int row=0;row<counter;row++){
					for(int col=0;col<4;col++){
						System.out.println("loop");
						System.out.println(d.data[row][col]);
						pdftable.addCell(d.data[row][col]);
					}
				}
				doc.add(pdftable);
				doc.close();
				System.out.println("done");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
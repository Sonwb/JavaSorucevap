/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///importlar
package dijital_exchange;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author umutr
 */
public class ayarlar extends JFrame implements ActionListener {
    //Panel içi ekleme
        JLabel lbl_Soru,lbl_sonuc,lbl_deger;
        JRadioButton rdi_A,rdi_B,rdi_C,rdi_D;
        JButton btn_onay;
       
         
        Sorular [] soru =new Sorular[6];
        int deger =0;
        int sorusayac=0;
        int dogrusayac=0;
        int yanlıssayac=0;
        //panel içi ekleme tanımları

    /**
     *JPanel Ekleme Uyarılar.
     */ 
        public ayarlar(){
         setSize(700, 500);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setTitle("Dijial Exchange");
         setLocationRelativeTo(null);
         JPanel panel1 = new JPanel();
        
   
         lbl_Soru =new JLabel();
         lbl_sonuc =new JLabel();
         lbl_deger =new JLabel();
         rdi_A = new JRadioButton();
         rdi_B = new JRadioButton();
         rdi_C = new JRadioButton();
         rdi_D = new JRadioButton();
     
         btn_onay = new JButton("Diğer Soruya Geç");
         
       

        lbl_Soru.setBounds(30,40,450,300);  
        rdi_A.setBounds(50,80,1000,20);  
        rdi_B.setBounds(50,110,1000,20);  
        rdi_C.setBounds(50,140,1000,20);  
        rdi_D.setBounds(50,170,1000,20);  
        btn_onay.setBounds(260,300,150,50);
        lbl_sonuc.setBounds(300,250,140,50); 
  
            
         btn_onay.addActionListener(this);
        
         btn_onay.setActionCommand("ekle");
         
        
         panel1.add(lbl_Soru); 
         add(lbl_sonuc);
         add(lbl_deger);
         add(rdi_A);
         add(rdi_B);
         add(rdi_C);
         add(rdi_D);
         add(btn_onay);
        
         add(panel1);
         Soruekleme();
         Soruyansıt(sorusayac);
         
    }
    //Soru ekleme kısmı
    
    /**
     *Soruekleme Sınıfında Soruları "txt" dosya türünden çekip verileri soru dizisine sıralı şekilde atıyoruz.
     * 
     */
    public void Soruekleme(){
        
         FileReader dosya_okuyucu;
         BufferedReader  okuyucu;
            try {
                 String yol = System.getProperty("user.home") + "\\Desktop\\soru.txt\\";
                dosya_okuyucu= new FileReader(yol);
                okuyucu=  new BufferedReader(dosya_okuyucu);
                String satir;
                
                
               
                while( (satir=okuyucu.readLine()) !=null){
                    String soru_metni=satir;
                    String s_A= okuyucu.readLine();
                    String s_B= okuyucu.readLine();
                    String s_C= okuyucu.readLine();
                    String s_D= okuyucu.readLine();
                    String cevap= okuyucu.readLine();
                    
                    Sorular.Cevaplar dogru_cevap = null;
                    if (cevap.equalsIgnoreCase("A")) {
                        dogru_cevap=Sorular.Cevaplar.CEVAP_A;
                    }
                    else if (cevap.equalsIgnoreCase("B")) {
                        dogru_cevap=Sorular.Cevaplar.CEVAP_B;
                    }
                     else if (cevap.equalsIgnoreCase("C")) {
                        dogru_cevap=Sorular.Cevaplar.CEVAP_C;
                    }
                      else if (cevap.equalsIgnoreCase("D")) {
                        dogru_cevap=Sorular.Cevaplar.CEVAP_D;
                    }
                    if(dogru_cevap !=null){
                        soru[deger]=new Sorular(soru_metni,s_A,s_B,s_C,s_D,dogru_cevap);
                        deger++;
                    }
                    else{deger--;}
                    
                }
                okuyucu.close();
                dosya_okuyucu.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }

         }
    //Sorueklemeden gelen verileri label radioa yansıtıyor 

    /**
     *Soru Ekleme Sınıfından Gelen verileri soru Dizisinden Label ve  Radiobuttonlara Aktarıyoruz.
     * @param soru_no
     */
        public void Soruyansıt(int soru_no){
       
      lbl_Soru.setText(soru[soru_no].soru_metni);
      rdi_A.setText(soru[soru_no].sik_a);
      rdi_B.setText(soru[soru_no].sik_b);
      rdi_C.setText(soru[soru_no].sik_c);
      rdi_D.setText(soru[soru_no].sik_d);
      
    }
    //gelen veriyi kontrol ediyor

    /**
     * Verilen Cevabı Soruları Sorular Sınıfından Kontrol_C Sınıfından Kontrol Sağlayıp "True" veya "False" Değeri Döndürüyoruz.
     * @param verilen_cevap
     * @return
     */
        public boolean cevap_kontrol(Sorular.Cevaplar verilen_cevap){
        
       return soru[sorusayac].Kontrol_c(verilen_cevap);
    }
    
    //button içi boş  veya hangi butonu seçtiğini anlamak için event ayarı
    
/**
*   Button İçi olaylar, Kontroller, Değer Görme , Uygulama kapatma, Resetleme.
*   
* @param olay
*@since
* @author umutr
*/
    @Override
    public void actionPerformed(ActionEvent olay) {
        
        if (olay.getActionCommand().equals("ekle")) {
             boolean kontrol  ;
        if (rdi_A.isSelected()) {
                rdi_A.setSelected(false);
               kontrol= cevap_kontrol(Sorular.Cevaplar.CEVAP_A);

        }
        else if (rdi_B.isSelected()) {
            rdi_B.setSelected(false);
            kontrol= cevap_kontrol(Sorular.Cevaplar.CEVAP_B);
             
        }
        else if (rdi_C.isSelected()) {
            rdi_C.setSelected(false);
            kontrol= cevap_kontrol(Sorular.Cevaplar.CEVAP_C);
             
        }
        else if (rdi_D.isSelected()) {
             rdi_D.setSelected(false);
             kontrol=cevap_kontrol(Sorular.Cevaplar.CEVAP_D);
             
        }
        else{//Boş geçerse yanlış  vericek
         kontrol =false;
         yanlıssayac--;
          
        }
        
        //kaç doğru yaptı diye öğrenmek için ifler ile sayaçları attırıyoruz.
        if (kontrol) {
            dogrusayac++;
            lbl_sonuc.setText("Doğru bildin");
            
        }
       if (kontrol==false) {
            yanlıssayac++;
            lbl_sonuc.setText("Yanlış ");
      
        }   
        
        sorusayac++;
        
        if (sorusayac <deger) {
            Soruyansıt(sorusayac);
        }//soru bitimi sonuçlar
        else {
                
        
            String [] secimler = { "Sonuçları Göster", "Tekrar Başlat", "Uygulamadan Çık" };
        int secim = JOptionPane.showOptionDialog(null, "Hangisini Seçmek istersin ?", "Seçenekler", JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE, null,
        secimler,secimler[0]);

            if(secim == JOptionPane.YES_OPTION ){
               
                JOptionPane.showMessageDialog(this,dogrusayac+" Tane doğru\n"+yanlıssayac+" Tane yanlış \n"+(deger-(dogrusayac+yanlıssayac))+" Tane Boş\n"+"Sorular Bitti. \nSkorun ="+dogrusayac*16.66666666666666);
                System.exit(0);
            }
            else if(secim == JOptionPane.NO_OPTION ){
                sorusayac=0;
             if (sorusayac <deger) {
                 
            Soruyansıt(sorusayac);
            }
              }
            else if(secim == JOptionPane.CANCEL_OPTION ){
               System.exit(0);
            }

        }
        
        
      
        }
       
        
       
    }


   
    
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijital_exchange;

/**
 *
 * @author umutr
 */
public class Sorular {
    
    String soru_metni;
    String sik_a , sik_b , sik_c ,sik_d ; 
    String lbl_Soru;

   
    

    /**
     *Enum Sayesinde int ile değerleri kontrol etmek yerine enum ile ediyoruz sadece "True" "False" Döndürür.
     */
        public  enum Cevaplar{CEVAP_A,CEVAP_B,CEVAP_C,CEVAP_D}
    Cevaplar dogru_cevap;
//soruların counstructorları
    
    /**
     *Sorular Construtorları.
     * @param soru_metni
     * @param sik_a
     * @param sik_b
     * @param sik_c
     * @param sik_d
     * @param dogru_cevap
     */
    public Sorular(String soru_metni, String sik_a, String sik_b, String sik_c, String sik_d, Cevaplar dogru_cevap) {
        this.soru_metni = soru_metni;
        this.sik_a = sik_a;
        this.sik_b = sik_b;
        this.sik_c = sik_c;
        this.sik_d = sik_d;
        this.dogru_cevap = dogru_cevap;
    }


     //enumden cevap nesnesi üretip kontrol ediyoruz return olarak t f döndürücek
     
    /**
     *Enumden Gelen değeri Cevaplardan oluşturduğumuz nesne ile bize verilecek olan cevabı kontrol edip return olarak "True" "False" Değeri döndürüyoruz.
     * @param Kontrol_c
     */
     boolean Kontrol_c(Cevaplar cevap){
       
        if (dogru_cevap == cevap) {    
            return true;     
        }
        else  {return false;}
    }
   
}
   
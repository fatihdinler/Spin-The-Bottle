package com.calculator.sisecevirmeceoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class normalGameScreen extends AppCompatActivity implements Serializable {

    private View questionRectangle;
    private ImageView bottleNormalGame;
    private Random random = new Random(55);
    private Button btnDoğruluk;
    private Button btnCesaretlik;
    private Button btnRepeat;
    private TextView questionText;
    public static ArrayList<String> questionDatabaseDoğruluk = new ArrayList<>();
    public static ArrayList<String> questionDatabaseCesaretlik = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_game_screen);

        /** View'ların bağlama işlemleri. */
        questionRectangle = findViewById(R.id.questionRectangle);
        bottleNormalGame = findViewById(R.id.bottleNormalGame);
        btnDoğruluk = findViewById(R.id.btnDoğruluk);
        btnCesaretlik = findViewById(R.id.btnCesaretlik);
        questionText = findViewById(R.id.questionText);
        btnRepeat = findViewById(R.id.btnRepeat);


        /** Button ve soru bulutunun opaklığını ayarladım. */
        questionRectangle.setAlpha(0.7f);
        btnDoğruluk.setAlpha(0.7f);
        btnCesaretlik.setAlpha(0.7f);

        /** onCreate() metodu çalışır çalışmaz butonların tıklanma özelliklerini kapat. Böylelikle
         * kullanıcıların şişeye dokunmadan soruları görmelerinin önüne geçersin. */
        btnDoğruluk.setEnabled(false);
        btnCesaretlik.setEnabled(false);
        btnRepeat.setEnabled(false);

        /** onCreate() çalıştığı anda kullanıcıya mesaj ver. */
        Toast.makeText(this, "Oyuna başlamak için şişeye dokunmanız gerekmektedir.", Toast.LENGTH_SHORT).show();

        bottleNormalGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Şişeye her tıklanıldığında rotateTheBottle() metodunu çalıştır. */
                rotateTheBottle(bottleNormalGame);

                /** Şişeye tekrardan tıklanıldığında questionText'i temizle.*/
                questionText.setText("");

                bottleNormalGame.setEnabled(false);
                btnRepeat.setEnabled(false);
            }
        });

        btnDoğruluk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Doğruluk butonuna tıklanıldığında her iki butonun tıklanılma özelliğini kapat.
                 * Bu özellik şişeye yeniden dokunulduğunda true olarak değiştirilecek. */
                btnDoğruluk.setEnabled(false);
                btnCesaretlik.setEnabled(false);
                questionText.setText(selectQuestion(questionDatabaseDoğruluk));
                questionText.startAnimation(AnimationUtils.loadAnimation(normalGameScreen.this, R.anim.slide_in_right));

                bottleNormalGame.setEnabled(true);
                btnRepeat.setEnabled(true);
            }
        });

        btnCesaretlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Cesaretlik butonuna tıklanıldığında her iki butonun tıklanılma özelliğini kapat.
                 * Bu özellik şişeye yeniden dokunulduğunda true olarak değiştirilecek. */
                btnCesaretlik.setEnabled(false);
                btnDoğruluk.setEnabled(false);
                questionText.setText(selectQuestion(questionDatabaseCesaretlik));
                questionText.startAnimation(AnimationUtils.loadAnimation(normalGameScreen.this, R.anim.slide_in_left));

                bottleNormalGame.setEnabled(true);
                btnRepeat.setEnabled(true);
            }
        });

        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = random.nextInt(2);

                /** Üretilen sayının tek mi çift mi olduğuna göre rastgele bir soru seçer. */
                if(randomNumber % 2 == 1) {
                    questionText.setText(selectQuestion(questionDatabaseCesaretlik));
                    questionText.startAnimation(AnimationUtils.loadAnimation(normalGameScreen.this, R.anim.slide_in_left));
                }
                else {
                    questionText.setText(selectQuestion(questionDatabaseDoğruluk));
                    questionText.startAnimation(AnimationUtils.loadAnimation(normalGameScreen.this, R.anim.slide_in_right));
                }
                btnRepeat.setEnabled(false);
                bottleNormalGame.setEnabled(true);
            }
        });

        /** Sorular için veritabanı */
        questionDatabaseDoğruluk.add("Görünmez olsan ilk olarak ne yapardın?");
        questionDatabaseDoğruluk.add("Herkesten sakladığın en büyük sırrın ne?");
        questionDatabaseDoğruluk.add("Sosyal medyada en son kimi stalkladın?");
        questionDatabaseDoğruluk.add("Üç dilek hakkın olsa bunları ne için kullanırdın?");
        questionDatabaseDoğruluk.add("Yarın piyango sana çıksa satın alacağın ilk şey ne olurdu?");
        questionDatabaseDoğruluk.add("Birini ekmek için hangi yalanı söylersin?");
        questionDatabaseDoğruluk.add("En son kime, ne yalan söyledin?");
        questionDatabaseDoğruluk.add("En utanç verici ilk buluşma anını anlat.");
        questionDatabaseDoğruluk.add("Issız bir adaya düşsen yanına alacağın 5 şey nedir?");
        questionDatabaseDoğruluk.add("En son ne zaman, ne için ağladın?") ;
        questionDatabaseDoğruluk.add("Ömrünün sonuna kadar sadece tek bir şarkı dinleyebilecek olsan bu ne olurdu?") ;
        questionDatabaseDoğruluk.add("Ömrünün sonuna kadar sadece tek bir şey yiyebilecek olsan bu ne olurdu?") ;
        questionDatabaseDoğruluk.add("Bugüne kadar gördüğün en garip rüya neydi?") ;
        questionDatabaseDoğruluk.add("En büyük korkun ne?") ;
        questionDatabaseDoğruluk.add("İnsanların senin hakkındaki en büyük yanılgılarının ne olduğunu düşünüyorsun?") ;
        questionDatabaseDoğruluk.add("Hoşlanmadığın bir ortamdan kaçmak için hiç yalan söyledin mi?") ;
        questionDatabaseDoğruluk.add("En son ne için para harcadığına pişman oldun?") ;
        questionDatabaseDoğruluk.add("Hayatının en güzel/kötü gününü anlat.") ;
        questionDatabaseDoğruluk.add("Bu masadaki birinin yerine geçecek ve onun hayatını yaşayacak olsan bu kim olurdu?");
        questionDatabaseDoğruluk.add("Hiç arkadaşının sırrını başkasıyla paylaştın mı?") ;
        questionDatabaseDoğruluk.add("Benim mesajımı hiç görmezden geldin mi. Neden bunu yaptın?") ;
        questionDatabaseDoğruluk.add("Hiç en iyi arkadaşına yalan söyledin mi?") ;
        questionDatabaseDoğruluk.add("En iyi 2 arkadaşın arasında seçim yapsan hangisini seçerdin?") ;
        questionDatabaseDoğruluk.add("En iyi arkadaşının en sevmediğin huyu nedir?") ;
        questionDatabaseDoğruluk.add("Sevdiğin ama açılamadığın kişi sana en yakın arkadaşını sevdiğini söylese ne yapardın?") ;
        questionDatabaseDoğruluk.add("Arkadaşının sevgilisini aldattığını bilseydin ne yapardın?") ;
        questionDatabaseDoğruluk.add("Kendini daha iyi biri gibi göstermek için en iyi arkadaşın hakkında yalan söyledin mi?") ;
        questionDatabaseDoğruluk.add("Odadaki herkese 1’den 10’a kadar puan verin, 10’u en sıcak olanı; 1 ise en kötü ve soğuk olanı.") ;
        questionDatabaseDoğruluk.add("Bu odadaki en sinir bozucu kişi kim?") ;




        questionDatabaseCesaretlik.add("Bu masadan birinin senin yerine tweet/instagram gönderisi atmasına izin ver.");
        questionDatabaseCesaretlik.add("Bu masadan birinin senin yerine birine mesaj atmasına izin ver.");
        questionDatabaseCesaretlik.add("Bu masadan birinin taklidini yap ama kim olduğunu söyleme.");
        questionDatabaseCesaretlik.add("Herkesin önünde kendi kareografinle dans et.");
        questionDatabaseCesaretlik.add("Aile bireylerinden birini ara ve onu çok korkutacak bir şaka yap.");
        questionDatabaseCesaretlik.add("Bir dakika boyunca plank pozisyonunda dur.");
        questionDatabaseCesaretlik.add("Çok kötü çıktığını düşündüğün bir fotoğrafı sosyal medyada paylaş.");
        questionDatabaseCesaretlik.add("En son attığın 5 mesajı yüksek sesle oku.");
        questionDatabaseCesaretlik.add("Masadaki insanların en sevmediğin özelliklerini söyle.");
        questionDatabaseCesaretlik.add(" Hoşlandığın kişinin en eski instagram gönderilerinden birini beğen.");
        questionDatabaseCesaretlik.add("Hakkında bir doğru ve bir yanlış bilgi paylaş. Masadakiler hangisinin doğru olduğunu tahmin etsin.") ;
        questionDatabaseCesaretlik.add("Gizli yeteneğini göster.") ;
        questionDatabaseCesaretlik.add(" Rastgele bir numara çevir ve karşıdaki kişiye bir fıkra anlat.");
        questionDatabaseCesaretlik.add("En sevdiğin kıyafetlerinden birini bir arkadaşına hediye et.") ;
        questionDatabaseCesaretlik.add("Eski sevgilini ara ve onu çok özlediğini söyle.") ;
        questionDatabaseCesaretlik.add("Telefonunu bu masadan birine ver ve tüm gün boyunca gelen mesajları/aramaları o yanıtlasın.") ;
        questionDatabaseCesaretlik.add("Herkesin önünde en sevdiğin şarkıyı baştan sona söyle.");
        questionDatabaseCesaretlik.add("Instagramda karşına çıkan ilk 5 hikayeye cevap ver.") ;
        questionDatabaseCesaretlik.add("Sıradaki 5 dakika boyunca masadakiler ne derse onu yap.") ;
        questionDatabaseCesaretlik.add("Bir gün boyunca sadece arkadaşlarının zevkine göre giyin.") ;

    }

    /** Buton listener içerisine atıldı. */
    public void rotateTheBottle(ImageView view) {

        /** 0 ile 18000 arasında random bir sayı üret. */
        int randomNumber = random.nextInt(1800);

        Log.e("rotated" , String.valueOf(1800 - randomNumber));

        /** Parametreye gönderilen ImageView'ı 1800 - randomNumber kadar döndür ve bu işlem 3 saniye
         * sürsün. */
        view.animate().rotation(1800 - randomNumber).setDuration(3000).start();

        /** Resme tekrar tıklanıldığında butonları aktif et. */
        btnCesaretlik.setEnabled(true);
        btnDoğruluk.setEnabled(true);
        btnRepeat.setEnabled(true);

    }

    /** Bu metodu arrayList içerisinden soru seçmek için kullandım. Geriye String return verir, bu
     * return value daha sonra buttonlara tıklanıldığında kullanılır. */
    public String selectQuestion(ArrayList arrayList) {
        int len = arrayList.size();
        int randomNumberForQuestion = random.nextInt(len);

        String returnValue = (String) arrayList.get(randomNumberForQuestion);

        return returnValue;
    }

    public ArrayList<String> getQuestionDatabaseDoğruluk() {
        return questionDatabaseDoğruluk;
    }

    /** Kullanıcı soru_ekleme.class içerisinden soruları editText üzerine yazar. Daha sonra,
     * bu metot diğer sınıftan çağrılır. Bu sayede soruları saklamak için farklı arrayListler
     * kullanılmaz.*/
    public void diğerSınıftanGelenDoğrulukSorularınıEkle(String mesaj) {
        questionDatabaseDoğruluk.add(mesaj);
    }

    /** Aynı şeyi cesaretlik için yapar. */
    public void diğerSınıftanGelenCesaretlikSorularınıEkle(String mesaj) {
        questionDatabaseCesaretlik.add(mesaj);
    }

    public ArrayList<String> getQuestionDatabaseCesaretlik() {
        return questionDatabaseCesaretlik;
    }

    public void setQuestionDatabaseCesaretlik(ArrayList<String> questionDatabaseCesaretlik) {
        this.questionDatabaseCesaretlik = questionDatabaseCesaretlik;
    }
}
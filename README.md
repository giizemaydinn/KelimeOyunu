# KelimeOyunu

Kelime Oyunu, oynanan bölümün zorluğuna göre kelime sayısı ve kelime uzunlukları belirlenerek dinamik bulmacalar oluşturan klasik bir bulmaca oyunudur. Uygulama Android Studio ortamında LibGDX kütüphanesi kullanılarak Java dilinde geliştirilmiştir.

**Giriş Ekranı ve Puan Tablosu**

Giriş ekranından bölümlerdeki en yüksek puana sahip olan oyunculara ulaşılabilir. Oyna butonuna basılarak direkt oyuna geçiş 
yapılabilir. 

![giris-ekrani](https://user-images.githubusercontent.com/93381527/219941263-e3960da7-1e10-4b26-b273-9989bbe7ff8c.png)
![puan-tablosu](https://user-images.githubusercontent.com/93381527/219941272-2167fed4-aaae-4320-bc00-17e51cf7ddb5.png)

**Bölüm Seçme Ekranları**

Giriş ekranındaki oyna butonu oyuncunun kaldığı bölümden devam etmesini sağlar. İstenilen bölümü seçmek için oyun ekranında bulunan geri butonuna basılıp bölüm seçme ekranına geçilebilir. Buradan bölüm ve alt bölüm seçilir. Oyuncu henüz geçemediği bölümden sonraki bölümlere erişemez.

![level-secim](https://user-images.githubusercontent.com/93381527/219941275-19ffe420-1321-4e75-b34a-1ca1d978e959.png)
![alt-level-secim](https://user-images.githubusercontent.com/93381527/219941278-332cbfdd-c436-4ff3-98df-e7ee68544db5.png)

**Oyun ve Oyun Sonu Ekranları**

Oyuncu, verilen harflerden bulmacadaki kelimeyi bulmaya çalışır. Harf karıştırma butonuyla harflerin yerleri değiştirerek veya harf ekle butonuyla harf alarak yardım alabilir.  
Ekranın üst kısmında, oynanan bölüm ve oyuncunun puanı bulunur. Puan yanlış harf kombinasyonları, geçen süre ve alınan harf sayısıyla ters orantılıdır.  
Oyuncu bölümü tamamlayınca oyun sonu ekranında puanı ve o bölümde en yüksek puana sahip oyuncunun adı ve puanı yer almaktadır. Bu ekrana tıklayıp sıradaki bölüme geçilir. 

![oyun-ekrani](https://user-images.githubusercontent.com/93381527/219941284-f22e9531-1bf4-467a-a72b-838406d20652.png)
![bolum-sonu](https://user-images.githubusercontent.com/93381527/219941287-79fac90d-a75d-414a-b400-b54b9ac90379.png)


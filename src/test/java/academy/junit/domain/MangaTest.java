package academy.junit.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MangaTest {
    private Manga manga1;
    private Manga manga2;

    @BeforeEach
    public void setUp(){
        manga1 = new Manga("KakashiHatashi", 22);
        manga2 = new Manga("KakashiHatashi", 22);
//        manga2 = new Manga("HatashiKakarejo", 26);

    }

    @Test
    public void accessors_ReturnData_WhenInitialize(){
        Assertions.assertEquals("KakashiHatashi", manga1.name());
        Assertions.assertEquals(22, manga1.episodes());
    }

    @Test
    public void equals_ReturnTrue_WhenObjectsAreTheSame(){
        Assertions.assertEquals(manga1, manga2);
    }

    @Test
    public void hashCode_ReturnTrue_WhenObjectsAreTheSame(){
        Assertions.assertEquals(manga1, manga2);
    }

    @Test
    public void constructor_ThrowNullPointerException_WhenNameIsNull(){
        Assertions.assertThrows(NullPointerException.class, () -> new Manga(null, 12));
    }

    @Test
    public void isRecord_ReturnTrue_WhenCalledFromManga(){
        Assertions.assertTrue(Manga.class.isRecord());
    }
}
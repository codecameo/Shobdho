package bytes.wit.factory;

import android.app.Application;
import android.content.Context;

import bytes.wit.factory.interfaces.SectionInfoRepository;
import bytes.wit.factory.interfaces.WordListRespository;
import bytes.wit.factory.repositories.SectionRepository;
import bytes.wit.factory.repositories.WordListRepository;

/**
 * Created by Md. Sifat-Ul Haque on 5/26/2017.
 */

public class WordFactory {

    private static WordFactory mWordFactory;

    private WordFactory(){};

    public static WordFactory getWordFactoryInstance(){
        if(mWordFactory==null) {
            synchronized (WordFactory.class) {
                if (mWordFactory == null)
                    mWordFactory = new WordFactory();
            }
        }
        return mWordFactory;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public SectionInfoRepository getSectionProvider(Context context){
        return new SectionRepository(context);
    }

    public WordListRespository getWordListProvider(Application mApplication) {
        return new WordListRepository(mApplication);
    }
}

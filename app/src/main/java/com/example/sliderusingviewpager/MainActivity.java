package com.example.sliderusingviewpager;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
/*
ne7na t3lmna keef net3emal ma3 l viewpager bas ykoun fe fragemnt sa7 hala2 badna net3lam keef net3emal ma3 l viewpager mndoun fragemnt
ya3ne ne7na mnshof 2awa2t fe 3ana b applications l toters w 8atra 2awls she be7oto de3ye offers kaza fa enta btsser kel ma ta3mel slide 3ala hay bte5tefe w btbyen wa7de jdeede
2aw metl application l bank wallet mnle2e eno 3ana card fo2 ba3doun w fena na3mel 3lyhoun slide

keeef badna nblesh badna nest3mel addapter 5aso bel viepager esmo PagerAddapter

hala2 2awl she 5alena na3mel xml layout b2laba viewpager 2
ba3d heek badna na3mel cotume layout fe b2olabo image view masln bas heda layout badna ner3do bel viewpager

hala2 mna3mel class esmo PagerAddapter:
la net3emal ma3 l viewpager badna nest3mel addapter heda l addapter esmo PagerAddapter fa mn5le l class le 3mlne extends PagerAddapter
bas na3eml extend heda l class 3ando 2 method 2asaseyen houne getCount(),isViewFromObject
getcount():hayde lezm raje3 size taba3 l data le 3ande ya3ne ana 3ande data feha src image of bade 7ota hay data b2lab object msln w b2lab heda l class bade 3aref arraylist mno3 heda l object
ba3den bel getcount bade raje3 3adad l data le 3ande b2lab heda l arraylist l2no howe 2awal ma yblesh ye3red l pagers beshof adesh 3addoun 3ashn ye7jozloun maken bel viewpager

ba3den abl ma fout b tene method lezm zeed 2 method mawjoude b heda l class wa7de esma instantiateItem(),destroyItem
instantiateItem():hala2 3ande method 2awl method btestd3a hay l method mn 5elel bade 2a3mel inflate lal cotume layout le 3mlne w hyde l function bta3tene container ka parameter le howe l viewpager fa ana ba3d ma 2a3mel inflate lal layout bsayeva b view b variable mn no3 viwa w bade zeed 3al container hyde l page 7asab l postion ya3ne le bsser keef:
2awl she beshof kam page 3ande mn kelel l get item() bye7jezloun maken
ba3den btestd3a l instantiateItem() function bteb3tle ma3a l postion ta3et l container mawjoud 3ande le 7ajzto  ma3 l container taba3o
fa la n2ol la 2awl wa7de 2awl pager byeb3tlna l position ta3elo w l container l howe l viewpager fa ne7na mna3mel inflate lal layout le 3mlne w ba3den mnjeeb l image l mawjoude b data 7asab l position w ba3mel eno add to container heda l viewa fa howe by7mela w bezeda 3ala l viewpager l postion ela 0
byerja3 byestd3e amen mara tenye l instantiateItem() bas hal mara l byeb3tlk l postion ta3et tenye bekoun 1 w l container ta3elo kamen ba3mel inflate bjeeb l image 7asab l postion berja3 bzeeda 3al container la hyde l viwa ma3 l image tba3a heekkkk la y5les kel l pager le mawjouden 3al shshe

fa hala2 5alene 2a3ml Arraylits esma Pager mno3 integer l2no ana bas 3ande image
w b3ref l context kamen bara
ba3den ba3mel constructor bye5do arraylist w kamen bye5do context
hala2 bel instantiateItem() 3ashen ma kel mara bade e3roud wa7de eje 2a3mela inflate fa best3mel heda she    LayoutInflater layoutInflater=(LayoutInflater)container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); hyde btrj3le layoutInflate taba3 heda  context le howe l taba3 l viewpager fa btrje3lak layout inflater taba3 heda l container w enta bta3mel inflate 3lee badel ma kel mara tseer badak ta3mel layout inflater kel ma badak display la page m3yane
fa ne7na 3asehn ma kel mara na3mel layout inflater fa ne7na mna3mel getsystem layout inflater fa hay tare2a btzeed l performance eno mesh kel mara la7 yo3roud 3onsour la7 ya3mel object mnnlayout inflater la2 byerja3 byest3mel nafso zeto
hyda l code le mn7oto bel instantiateItem():
 LayoutInflater layoutInflater=(LayoutInflater)container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.costume_swipe,container,false);
        ImageView imageView=view.findViewById(R.id.image_view);
        imageView.setImageResource(Images.get(position));
        container.addView(view);
        return view;

2awl she mnjeeb layout inflater ba3den mn3mel inflate lal layout le 3mlne ba3den mn jeeb l image view le b2lab heda layout mn7ot feha data 7asab l postion ba3den mnzeed heda l view le b2labo image view 7asab l postion bel container le howe l viewpager
ba3den mn3mel return lal view 3ashen l2no l pager addapter 3atoul keep track lal view le 3emela eno aymta hayde l view 7a tedmar keef life cycel ta3ela heek manage it
bas l container.add(view) heye le bt5ale heda l view ybyen 3al shshe


hala2 ne7na badna bas na3mel swipe la page m3yane fa te5tefe yen3amala destroy fa 3ande function esma destroyitem byen3ama call bas iz wa7de mn l page batlet mbyne 3ala shshe bteb3tle l container w l object object le howe l view le n3malo return mn l intiateitem fa bel destroy bade bas tbtel l view mbyne na3mela scroll bade shela mn l cotianer fa ba3mel contianer.remove object ba3mel cas le heye l view ta3et l le 3mlneha bel intialete

e5er method heye l :isViewFromObject
hyade l method byen3amal call ba3d instantiateItem() hyde l method la na3mel verification la sho:
hayde l method btrj3le l view le heye l view le heye l page ta3et l viewpager w btrje3le object le bta3melo return bel insitiate method
fa hyde kel mara byen3amala call ba3d ma ten7at l view b2lab l viewpage instantiateItem() ya3ne b3d hyde l method
byen3ama call la na3mel verfication eno heda l view le howe l pager ma7tot feha hayde l view le howe data bel postion l mazbout

w hayde l method kamen byne3amala call b matra7 tene l2olak keef:
ne7na 3ana 3 page:A,B,C
fa ne7na 2awl ma nblesh mne3roud page A fa 2awl she mn3mela instantiateItem() ba3den mna3mel isViewFromObject mnshof hay l view mrakab 3lyha l view l mazout
ba3den  mna3mel scroll fa bada tbyen l page B fa 2awl she mnestd3e l isViewFromObject hyde 7a tshof eno hawde l view le 3ande bymeloun check equll la heda l object l jdeed le howe l page 2 fa 7a ydaweerrr ma yl2eha fa tetla3 false fa yestd3e l intaite method w ya3mel view jdede w nafs she bel nesbe lal page 3
hala2 la ne3tebr ne7na b page 3 fa 3mlna scroll back ya3ne rje3na mn page 3 la page2 fa  2awl she 7a testd3e isViewFromObject fa hyde 7a te5od l view le howe page 2 w 7a daweer hal hayde l page n3redt abl b mara b wa7de mn hawde l view fa tl2e wa7de l2no heye ma3rouda abl b mara fa ma7trou7 testd3e l intiate 7a teje l view page2 w terkab ma7ala ya3ne ka2no std3yenha bas
w nafs she iza rj3na mn page 2 la page 1 kamen 7a n2eha fa 7a tetla3 true fa kamen ma 7a nestd3e l intaite method 7a trou7 de8re te3roud l page 1


hala2 ba3d ma 5alsna l addpter mn blesh bel mainactivity:

-2awl she mn3ref l viewpage2,w mna3mel l viewpageraddpter ba3den
sta3mlna she esmo setPageTransformer hayde l method byen3amal call kel ma ne7na 3mlna scroll w jebna soura jdede 2awl parameter bte5do eno hal enta badak yen3amal lal pages b ya3ne yen3aml transform lal page b reverse order ya3ne ne7na bas na3mel scroll 3al sheml bada trou7 l page fa iza 7atyna false fa l pages 7a ysero yrou7o mn 2e5er wa7de la 2awalmwa7de ya3ne houne byejo fo2 ba3d e5er wa7de bel viewpager bas ta3mel scroll betrou7 iza kenet false
ama iza true 7a ykoun tarteb l pages 2awal she mn l 2awal lal e5er w bas na3mel scroll w tseer trou7 l page btseer trou7 2awal wa7de bterja3 tene scroll betroj7 tenye bterja3 telte heek

w hayde l fucntion bte5od mn 5elela na3mel animation mn 5elel class esmo ViewPager.PageTransformer mna3mel class extend la heda clas
w bta3ene method byen3amal call kel ma 3mlna scroll bt3tene l postion ta3et l page le heye l interval ta3eta mn -1 to 1 bas tkoun 3al lef btkoun -1 w bas tkoun 3al e5er right 1 w bas tkoun ceneter betkoun zero
bade bas ykoun l postion mn 0 2aw akatr bade ta3mel animation le howe heda ta8yer l x w ta8yer l y
page.setScaleY(0.9f);
page.setScaleX(0.9f-0.05f*position);
page.setTranslationX(-page.getWidth()*position);
page.setTranslationY(-40*position);


bas hay tare2a traditional w mesh kteer mne7a l 2a7san na3mela b recycele view w best3mel l viewpager













 */







public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<Integer> arrayList;
    PagerAddapter pagerAddapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList=new ArrayList<>();
        arrayList.add(R.drawable.image1);
        arrayList.add(R.drawable.iamge2);
        arrayList.add(R.drawable.image3);
        arrayList.add(R.drawable.image4);
        arrayList.add(R.drawable.iamge5);
        viewPager=findViewById(R.id.viewpager);
        pagerAddapter=new PagerAddapter(this,arrayList);
        viewPager.setPageTransformer(true, new ViewPagerStack(),View.LAYER_TYPE_NONE);
        viewPager.setAdapter(pagerAddapter);


    }
    class ViewPagerStack implements ViewPager.PageTransformer{

        @Override
        public void transformPage(@NonNull View page, float position) {
            if(position>=0){
                page.setScaleY(0.7f);
                page.setScaleX(0.7f-0.05f*position);
                page.setTranslationX(-page.getWidth()*position);
                page.setTranslationY(-30*position);

            }
        }
    }
}
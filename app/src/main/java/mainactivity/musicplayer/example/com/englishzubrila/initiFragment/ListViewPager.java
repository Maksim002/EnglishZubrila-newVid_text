package mainactivity.musicplayer.example.com.englishzubrila.initiFragment;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.englishzubrila.glavList.Listener;
import mainactivity.musicplayer.example.com.englishzubrila.initiFragment.contanerListViewPager.Adaptor;
import mainactivity.musicplayer.example.com.englishzubrila.initiFragment.contanerListViewPager.Model;
import mainactivity.musicplayer.example.com.englishzubrila.initiFragment.expandable.Product;
import mainactivity.musicplayer.example.com.englishzubrila.R;


public class ListViewPager extends Fragment implements Listener {

    private ViewPager viewPager;
    private Adaptor adaptor;
    private Integer[] colors = null;
    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private List<Model> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_view_pager, container, false);

        viewPager = view.findViewById(R.id.viewPager);

        getCompanies();
        return view;
    }

        private void getCompanies(){
            list = new ArrayList<>();
            list.add(new Model(R.drawable.kilers,"Эрнест Хэмингуэй. Киллеры",R.string.kilers,"https://drive.google.com/open?id=1SWcocqAqJ_qa9xqLBBe5RloLW7YyoR0G"));
            list.add(new Model(R.drawable.the_third_man,"The Third Man (Третий человек)",R.string.The_Third_Man,"https://drive.google.com/open?id=1CmuofozQFj8G02RgKljcp-GExNWOTP6t"));
            list.add(new Model(R.drawable.a_sound_of_thunder," Рэй Бредбери И грянул гром Ray Bradbury A Sound of Thunder",R.string.a_sound_of_thunder,"https://drive.google.com/open?id=16outXzpBroYtH4pdjAim5Ce9kF_-nG6Q"));
            list.add(new Model(R.drawable.scazki,"ИРЛАНДСКИЕ ВОЛШЕБНЫЕ СКАЗКИ Irish Fairy Tales",R.string.Irish_Fairy_Tales,"https://drive.google.com/open?id=13QjbIrWaBWSHijavyAuInclzYSUhfm6K"));
            list.add(new Model(R.drawable.besmaslesa,"Edward LEAR. A Book of Nonsense (Эдвард ЛИР. Книга бессмыслицы)",R.string.of_Nonsense,"https://drive.google.com/open?id=1dEMThCOWc2qdQ-seLOixIurshU_fmFld"));
            list.add(new Model(R.drawable.socol,"Dashiell Hammett. The Maltese Falcon (Дэшил Хэммет. Мальтийский сокол)",R.string.socol,"https://drive.google.com/open?id=1bhstB3urysUCuIPG4EdJmzyFSBL2uO1c"));
            list.add(new Model(R.drawable.ostrov,"Английский язык с Р.Л.Стивенсоном Остров сокровищ Robert Louis Stevenson Treasure Island",R.string.ostrov,"https://drive.google.com/open?id=1pDISoESI2AGtGx0w55KCd3xWnOELD8CU"));
            list.add(new Model(R.drawable.robert,"Английский язык с Конаном Robert E.Howard Роберт Говард",R.string.Robert_E_Howard,"https://drive.google.com/open?id=1Ygq1yOi80opJxxXJ88cxmk1gHXyBvM2X"));
            list.add(new Model(R.drawable.gandalf,"Английский язык с Мюриэль Спарк (рассказы) Портобелло Роуд The Portobello Road",R.string.The_Portobello,"https://drive.google.com/open?id=1w_MjrS6OtRw0Hg18XSLIuyRz8AvS3gmP"));
            list.add(new Model(R.drawable.walliam,"Уильям Сомерсет Моэм Театр William Somerset Maugham Theatre",R.string.somerset,"https://drive.google.com/open?id=1w_MjrS6OtRw0Hg18XSLIuyRz8AvS3gmP"));
            list.add(new Model(R.drawable.zpage,"Robinson Crusoe Written Anew for Children by James Baldwin",R.string.James,"https://drive.google.com/open?id=1Tvw134ijGeDJuJTP0FkUlcIZWD9tFK1f"));

            adaptor = new Adaptor(list,getContext(),this);


            viewPager.setAdapter(adaptor);
            viewPager.setPadding(50, 0, 50, 0);

            Integer[] colors_temp = {
                    getResources().getColor(R.color.color14),
                    getResources().getColor(R.color.color23),
                    getResources().getColor(R.color.color32),
                    getResources().getColor(R.color.color41),
                    getResources().getColor(R.color.color42),
                    getResources().getColor(R.color.color43),
                    getResources().getColor(R.color.color44),
                    getResources().getColor(R.color.color45),
                    getResources().getColor(R.color.color46),
                    getResources().getColor(R.color.color47),
            };

            colors = colors_temp;

            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    if (position < (adaptor.getCount() - 1) && position < (colors.length - 1)){
                        viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position],colors[position + 1]));
                    }else {
                        viewPager.setBackgroundColor(colors[colors.length - 1]);
                    }

                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }



    @Override
    public void onClikGaleri(int adapterPosition, Product product) {

    }

    @Override
    public void onClikGaleri(Model model) {
        Intent intent = new Intent(getContext(), WebViewB.class);
        intent.putExtra("Web", model);
        startActivity(intent);
    }
}

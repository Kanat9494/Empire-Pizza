package com.example.mypizza.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypizza.R;
import com.example.mypizza.RecyclerViewAdapter;
import com.example.mypizza.RecyclerViewItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private ArrayList<RecyclerViewItem> recyclerViewItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    LinearLayoutManager HorizontalLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.news_image, "Важная новость",
                "Уважаемые гости! Уведомляе"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.delivery_image, "Доставим вовремя " +
                "или подарим заказ", "Мы придерживаемся золотых правил"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.payment_image, "Оплати заказ " +
                "через мобильный кошелек", "Рады сообщить, что теперь доставку"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.birthday, "АКЦИЯ СЧАСТЛИВЫЙ " +
                "ИМЕНИНИК",
                "АКЦИЯ СЧАСТЛИВЫЙ ИМЕНИНИК. Империя Пиццы"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.children_birthday, "АКЦИЯ " +
                "ДЕСТКИЙ ДЕНЬ РОЖДЕНИЯ", "АКЦИЯ ДЕТСКИЙ ДЕНЬ РОЖДЕНИЯ. Если у Вашего"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.coca_cola, "Получи бутылку Coca" +
                "-Cola", "Закажи две любых пиццы и получи бутылку"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.invite_friend, "Пригласи друга",
                "Пригласи друга и получи 10 баллов после"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.bonus, "Баллы за регистрацию",
                "При регистрации в приложении Империя пиццы Бишкек"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.discount, "Получи скидку 5%",
                "Забери свой заказ сам и получи скидку"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.thanks, "БОНУСНАЯ ПРОГРАММА " +
                "БЛАГОДАРНОСТЬ", "Участники программы Любимый Гость - все, кто скачал"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(recyclerViewItems);
        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        HorizontalLayout = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,
                false);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(HorizontalLayout);


        return view;
    }
}
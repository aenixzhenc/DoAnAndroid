package com.huflit.goldtracker.ui.coin;

import com.huflit.goldtracker.data.model.coin.Coin;
import com.huflit.goldtracker.ui.base.BasePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinPresenter extends BasePresenter {

    private CoinView coinView;

    public CoinPresenter(CoinView coinView) {
        this.coinView = coinView;
    }

    public void getCoin(String date) {
        coinApiService.getCoin(date).enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
               // coinView.onLoadCoinSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                coinView.onLoadCoinFailed();
            }
        });
    }
}

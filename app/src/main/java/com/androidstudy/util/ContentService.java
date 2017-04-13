package com.androidstudy.util;

import android.util.Log;

import com.androidstudy.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

/**
 * Created by nextus on 2017. 4. 13..
 */

public interface ContentService {



    class Factory {
//
        private static final String CACHE_CONTROL = "Cache-Control";

        public static ContentService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://52.78.152.162:3000/")
                    .client(provideOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())  // Json Parser
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())  // RxAndroid 사용을 위한 옵션
                    .build();
            return retrofit.create(ContentService.class);
        }

        public static ContentService createVisitKoreaAPI() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.visitkorea.or.kr/openapi/service/rest/KorService/")
                    .client(provideOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())  // RxAndroid 사용을 위한 옵션
                    .build();
            return retrofit.create(ContentService.class);
        }

        private static OkHttpClient provideOkHttpClient ()
        {
            return new OkHttpClient.Builder()
                    .addInterceptor( provideHttpLoggingInterceptor() )
                    .build();
        }

        private static HttpLoggingInterceptor provideHttpLoggingInterceptor ()
        {
            HttpLoggingInterceptor httpLoggingInterceptor =
                    new HttpLoggingInterceptor( new HttpLoggingInterceptor.Logger()
                    {
                        @Override
                        public void log (String message)
                        {
                            Log.d("", message );
                        }
                    } );
            httpLoggingInterceptor.setLevel( BuildConfig.DEBUG ? HEADERS : NONE );
            return httpLoggingInterceptor;
        }

        public static Interceptor provideCacheInterceptor ()
        {
            return new Interceptor()
            {
                @Override
                public Response intercept (Chain chain) throws IOException
                {
                    Response response = chain.proceed( chain.request() );

                    // re-write response header to force use of cache
                    CacheControl cacheControl = new CacheControl.Builder()
                            .maxAge( 1, TimeUnit.MINUTES )
                            .build();

                    return response.newBuilder()
                            .header( CACHE_CONTROL, cacheControl.toString() )
                            .build();
                }
            };
        }
    }
}

package ffxiv.apiclient;

import ffxiv.dtos.ItemResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServiceFFXIV {
    @GET("item/{id}")
    Call<ItemResponse> getItem(@Path("id") int id);
}

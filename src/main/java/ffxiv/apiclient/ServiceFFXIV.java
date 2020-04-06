package ffxiv.apiclient;

import ffxiv.dtos.ItemResponse;
import ffxiv.dtos.SearchFCResponse;
import ffxiv.dtos.SearchFCResult;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceFFXIV {
    @GET("item/{id}")
    Call<ItemResponse> getItem(@Path("id") int id);

    @GET("freecompany/search")
    Call<SearchFCResponse> getFreeCompanyByName(@Query("name") String name, @Query("server") String server);
}

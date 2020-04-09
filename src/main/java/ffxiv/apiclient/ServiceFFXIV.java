package ffxiv.apiclient;

import ffxiv.dtos.CharacterByID;
import ffxiv.dtos.CharacterByNameResponse;
import ffxiv.dtos.ItemResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceFFXIV {
    @GET("item/{id}")
    Call<ItemResponse> getItem(@Path("id") int id);
    @GET("character/search")
    Call<CharacterByNameResponse> getCharacter(@Query("name") String forename,
                                               @Query("server") String server);
    @GET("character/{id}")
    Call<CharacterByID> getCharacterID(@Path("id") int id);
}

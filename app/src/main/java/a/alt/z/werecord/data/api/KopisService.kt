package a.alt.z.werecord.data.api

import a.alt.z.werecord.data.model.KopisResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KopisService {

    /**
     * http://www.kopis.or.kr/openApi/restful/pblprfr?service={api_key}&stdate=20160101&eddate=20160630&rows=10&cpage=1
     */
    @GET("pblprfr")
    fun search(
        @Query("stdate") startDate: Int = 20150101,
        @Query("eddate") endDate: Int = 20251231,
        @Query("cpage") currentPage: Int = 1,
        @Query("rows") rows: Int = 10,
        @Query("shprfnm", encoded = true) query: String
    ): Call<KopisResponse>

    /**
     * http://www.kopis.or.kr/openApi/restful/pblprfr/PF132236?service={api_key}
     */
    fun getDetail(id: String)
}
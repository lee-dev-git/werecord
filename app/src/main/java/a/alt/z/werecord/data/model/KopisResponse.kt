package a.alt.z.werecord.data.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "dbs", strict = false)
data class KopisResponse(
    @field:ElementList(
        name = "db",
        inline = true,
        required = false
    )
    var results: List<KopisPerformance>? = null
)
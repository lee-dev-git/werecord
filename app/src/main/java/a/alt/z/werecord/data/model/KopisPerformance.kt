package a.alt.z.werecord.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "db")
data class KopisPerformance(
    @field:Element(name = "mt20id")
    var id: String = "",
    @field:Element(name = "prfnm")
    var name: String = "",
    @field:Element(name = "prfpdfrom")
    var startDate: String = "",
    @field:Element(name = "prfpdto")
    var endDate: String = "",
    @field:Element(name = "fcltynm")
    var place: String = "",
    @field:Element(name = "poster")
    var poster: String = "",
    @field:Element(name = "genrenm")
    var genre: String = "",
    @field:Element(name = "prfstate")
    var state: String = "",
    @field:Element(name = "openrun")
    var openrun: String = ""
)
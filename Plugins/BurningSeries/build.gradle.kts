// use an integer for version numbers
version = 1

cloudstream {
    language = "de"
    // Alle diese Eigenschaften sind optional und können entfernt werden

    description = "Enthält: BurningSeries"
    authors = listOf("FukaAbi97")

    /**
     * Status int mit folgenden Werten:
     * 0: Down
     * 1: Ok
     * 2: Langsam
     * 3: Nur Beta
     */
    status = 1 // Standard ist 3, falls nicht angegeben

    tvTypes = listOf(
        "TvSeries",
        "Movie",
    )

    iconUrl = "https://www.google.com/s2/favicons?domain=burningseries.to&sz=%size%"
}

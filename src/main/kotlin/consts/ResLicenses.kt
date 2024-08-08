package consts

object ResLicenses {
    class ResLicense(val resName: String, val url: String, val license: License)
    class License(val name: String, val url: String)

    val licenses = listOf(
        ResLicense(
            "Spell Book",
            "https://icon-icons.com/zh/%E5%9B%BE%E6%A0%87/%E5%92%92%E8%AF%AD%E4%B9%A6/88820",
            License("CC BY 4.0", "https://creativecommons.org/licenses/by/4.0/")
        ),
        ResLicense(
            "Check Slime Chunk",
            "https://minecraft.wiki/w/Slime#Slime_chunks",
            License("CC BY-NC-SA 3.0", "https://creativecommons.org/licenses/by-nc-sa/3.0/")
        ),
        ResLicense(
            "六芒星の無料ピクトグラム",
            "https://icooon-mono.com/13032-%e5%85%ad%e8%8a%92%e6%98%9f%e3%81%ae%e7%84%a1%e6%96%99%e3%83%94%e3%82%af%e3%83%88%e3%82%b0%e3%83%a9%e3%83%a0/",
            License("ラインセンスについて", "https://icooon-mono.com/license/")
        )
    )
}
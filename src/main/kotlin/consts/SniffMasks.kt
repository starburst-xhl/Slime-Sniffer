package consts

object SniffMasks {

    private val round: Array<Array<Boolean>> = arrayOf(
        arrayOf(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false),
        arrayOf(false,false,false,false,false,false,true ,true ,true ,true ,true ,false,false,false,false,false,false),
        arrayOf(false,false,false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false,false,false),
        arrayOf(false,false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false,false),
        arrayOf(false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false),
        arrayOf(false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false),
        arrayOf(false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false),
        arrayOf(false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false),
        arrayOf(false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false),
        arrayOf(false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false),
        arrayOf(false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false),
        arrayOf(false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false),
        arrayOf(false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false),
        arrayOf(false,false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false,false),
        arrayOf(false,false,false,false,true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false,false,false),
        arrayOf(false,false,false,false,false,false,true ,true ,true ,true ,true ,false,false,false,false,false,false),
        arrayOf(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false)
    )
    private val square: Array<Array<Boolean>> = arrayOf(
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        arrayOf(true, true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ),
        )

    val sniffMasks = mapOf(
        "round" to round,
        "square" to square,
    )
}
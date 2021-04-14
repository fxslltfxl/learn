package apitest

import kotlin.collections.HashMap


fun main() {

    val map = HashMap<String, HashMap<String, String>>()

    val hashMap = HashMap<String, String>()
    hashMap["11"] = "11"
    hashMap["12"] = "11"
    hashMap["13"] = "11"
    hashMap["14"] = "11"
    map["1"] = hashMap
    val flatMap: List<Map.Entry<String, String>> = map.flatMap {
        it.value.asIterable()
    }
    print(flatMap)
}
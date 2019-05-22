package learngson

import bean.One
import utils.GsonFactory


fun main(args: Array<String>) {
    val instance = GsonFactory.getInstance()

    val toJson = instance.toJson(One("fxs", 18, null,"111"))

    print("")
}

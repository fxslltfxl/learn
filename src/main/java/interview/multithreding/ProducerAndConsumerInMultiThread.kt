package interview.multithreding

import interview.Sup

object ProducerAndConsumerInMultiThread {


    @JvmStatic
    fun main(args: Array<String>) {

        test("") {}
    }


    @Synchronized
    fun produce() {
        synchronized(this) { Sup() }
    }



    private fun test(c:String,a:(b:String)->Unit){
        a.run { }
    }
}

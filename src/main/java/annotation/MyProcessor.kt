package annotation

import java.util.*
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import kotlin.collections.HashMap
import kotlin.collections.Set
import kotlin.collections.forEach
import kotlin.collections.set

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/11/11
 */
class MyProcessor : AbstractProcessor() {


    private var methodInfo = HashMap<String, String>()

    override fun getSupportedAnnotationTypes(): Set<String> {
        val annotationTypes = LinkedHashSet<String>()
        annotationTypes.add(Subscriber::class.java.canonicalName)
        return annotationTypes

    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun process(annotations: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {


        annotations.forEach { annotation ->
            val elements = roundEnv.getElementsAnnotatedWith(annotation)

            elements.forEach { element ->
                val typeElement = element.enclosingElement as TypeElement
                val qualifiedClassName = typeElement.qualifiedName.toString()
                methodInfo[typeElement.simpleName.toString()] = qualifiedClassName
            }


            //java poet  TODO

        }












        return false
    }
}

fun main() {

}
//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易  
//          佛曰:  
//                  写字楼里写字间，写字间里程序员；  
//                  程序人员写程序，又拿程序换酒钱。  
//                  酒醒只在网上坐，酒醉还来网下眠；  
//                  酒醉酒醒日复日，网上网下年复年。  
//                  但愿老死电脑间，不愿鞠躬老板前；  
//                  奔驰宝马贵者趣，公交自行程序员。  
//                  别人笑我忒疯癫，我笑自己命太贱；  
//                  不见满街漂亮妹，哪个归得程序员？ 
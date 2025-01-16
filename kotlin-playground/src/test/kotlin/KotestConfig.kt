import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode

class KotestConfig : AbstractProjectConfig() {
    override val parallelism = Runtime.getRuntime().availableProcessors()

    override val isolationMode = IsolationMode.InstancePerLeaf
}

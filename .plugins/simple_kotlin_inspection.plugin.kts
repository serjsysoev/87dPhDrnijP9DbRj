import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.idea.structuralsearch.visitor.KotlinRecursiveElementVisitor
import org.jetbrains.kotlin.psi.KtImportDirective

ide.inspection.visitFile { holder, file ->
    if (file.language !is KotlinLanguage) return@visitFile

    file.accept(object : KotlinRecursiveElementVisitor() {
        override fun visitImportDirective(importDirective: KtImportDirective) {
            holder.registerProblem(importDirective.originalElement, "Imports are forbidden!")
            super.visitImportDirective(importDirective)
        }
    })
}
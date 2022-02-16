package com.github.serjsysoev.simple_inspection

import com.github.serjsysoev.MyBundle
import com.intellij.codeInspection.*
import com.intellij.psi.PsiFile
import org.jetbrains.kotlin.idea.structuralsearch.visitor.KotlinRecursiveElementVisitor
import org.jetbrains.kotlin.idea.util.ProjectRootsUtil
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtImportDirective


/**
 * Implements an inspection to detect imports.
 */
class SimpleInspection : LocalInspectionTool() {
  override fun checkFile(file: PsiFile, manager: InspectionManager, isOnTheFly: Boolean): Array<ProblemDescriptor>? {
    if (file !is KtFile || !ProjectRootsUtil.isInProjectSource(file)) {
      return null
    }

    val problemDescriptors = mutableListOf<ProblemDescriptor>()
    file.accept(object : KotlinRecursiveElementVisitor() {
      override fun visitImportDirective(importDirective: KtImportDirective) {
        problemDescriptors += manager.createProblemDescriptor(
          importDirective.originalElement,
          MyBundle.message("simpleInspectionMessage"),
          true,
          emptyList<LocalQuickFix>().toTypedArray(),
          ProblemHighlightType.GENERIC_ERROR_OR_WARNING
        )
        super.visitImportDirective(importDirective)
      }
    })

    return problemDescriptors.toTypedArray()
  }

}
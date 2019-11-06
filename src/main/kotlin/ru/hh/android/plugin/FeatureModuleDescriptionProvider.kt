package ru.hh.android.plugin

import com.android.tools.idea.npw.model.NewModuleModel
import com.android.tools.idea.npw.module.ModuleDescriptionProvider
import com.android.tools.idea.npw.module.ModuleGalleryEntry
import com.android.tools.idea.wizard.model.SkippableWizardStep
import com.google.common.collect.ImmutableList
import com.intellij.openapi.project.Project
import com.intellij.ui.layout.panel
import java.awt.Image
import javax.swing.JComponent


class FeatureModuleDescriptionProvider : ModuleDescriptionProvider {

    override fun getDescriptions(project: Project): MutableCollection<out ModuleGalleryEntry> {
        return ImmutableList.of(FeatureModuleEntry())
    }

    private class FeatureModuleEntry : ModuleGalleryEntry {
        override fun getIcon(): Image? = null
        override fun getName(): String = "Feature module"
        override fun getDescription(): String = "Feature module description"
        override fun createStep(model: NewModuleModel): SkippableWizardStep<*> = CreateFeatureModuleStep(model)
    }

    private class CreateFeatureModuleStep<M : com.android.tools.idea.wizard.model.WizardModel>(model: M)
        : SkippableWizardStep<M>(model, "Step 1") {

        override fun getComponent(): JComponent = panel { titledRow("My step title") {} }

    }

}
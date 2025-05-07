package app.revanced.patches.fairemail.pro

import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val enableProPatch = bytecodePatch(
    name = "Enable Pro features",
    description = "Enable Pro features",
) {
    compatibleWith("eu.faircode.email")

    execute {
        isProFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """,
        )
    }
}
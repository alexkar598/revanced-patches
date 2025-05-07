package app.revanced.patches.fairemail

import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val spoofFingerprintPatch = bytecodePatch(
    name = "Spoof fingerprint",
    description = "Spoof fingerprint detection",
) {
    compatibleWith("eu.faircode.email")

    execute {
        hasValidFingerprintFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """,
        )
    }
}
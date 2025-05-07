package app.revanced.patches.fairemail.fingerprint

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal val hasValidFingerprintFingerprint = fingerprint {
    accessFlags(AccessFlags.STATIC)
    returns("Z")
    parameters("Landroid/content/Context;")

    custom { method, _ ->
        method.name == "hasValidFingerprint" && method.definingClass == "Leu/faircode/email/Helper;"
    }
}

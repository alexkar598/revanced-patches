package app.revanced.patches.fairemail

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal val isProFingerprint = fingerprint {
    accessFlags(AccessFlags.STATIC)
    returns("Z")
    parameters("Landroid/content/Context;")
    strings("pro")

    custom { method, _ ->
        method.name == "isPro" && method.definingClass == "Leu/faircode/email/ActivityBilling;"
    }
}

internal val hasValidFingerprintFingerprint = fingerprint {
    accessFlags(AccessFlags.STATIC)
    returns("Z")
    parameters("Landroid/content/Context;")

    custom { method, _ ->
        method.name == "hasValidFingerprint" && method.definingClass == "Leu/faircode/email/Helper;"
    }
}

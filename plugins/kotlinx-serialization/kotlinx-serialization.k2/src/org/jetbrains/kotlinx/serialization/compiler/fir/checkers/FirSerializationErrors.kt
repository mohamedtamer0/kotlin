/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlinx.serialization.compiler.fir.checkers

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.diagnostics.*
import org.jetbrains.kotlin.fir.symbols.impl.FirClassSymbol
import org.jetbrains.kotlin.fir.types.ConeKotlinType
import org.jetbrains.kotlin.psi.KtAnnotationEntry

object FirSerializationErrors {
    val INLINE_CLASSES_NOT_SUPPORTED by error2<PsiElement, String, String>()

    val PLUGIN_IS_NOT_ENABLED by warning0<PsiElement>()
    val ANONYMOUS_OBJECTS_NOT_SUPPORTED by error0<PsiElement>()
    val INNER_CLASSES_NOT_SUPPORTED by error0<PsiElement>()

    val EXPLICIT_SERIALIZABLE_IS_REQUIRED by warning0<PsiElement>()

    val SERIALIZABLE_ANNOTATION_IGNORED by error0<KtAnnotationEntry>()
    val NON_SERIALIZABLE_PARENT_MUST_HAVE_NOARG_CTOR by error0<KtAnnotationEntry>()
    val PRIMARY_CONSTRUCTOR_PARAMETER_IS_NOT_A_PROPERTY by error0<KtAnnotationEntry>()
    val DUPLICATE_SERIAL_NAME by error1<KtAnnotationEntry, String>()
    val DUPLICATE_SERIAL_NAME_ENUM by error3<PsiElement, FirClassSymbol<*>, String, String>()
    val SERIALIZER_NOT_FOUND by error1<PsiElement, ConeKotlinType>()
    val SERIALIZER_NULLABILITY_INCOMPATIBLE by error2<PsiElement, ConeKotlinType, ConeKotlinType>()
    val SERIALIZER_TYPE_INCOMPATIBLE by warning3<PsiElement, ConeKotlinType, ConeKotlinType, ConeKotlinType>()
    val LOCAL_SERIALIZER_USAGE by error1<PsiElement, ConeKotlinType>()
    val TRANSIENT_MISSING_INITIALIZER by error0<PsiElement>()

    val TRANSIENT_IS_REDUNDANT by warning0<PsiElement>()

    val INCORRECT_TRANSIENT by warning0<PsiElement>()

    val REQUIRED_KOTLIN_TOO_HIGH by error3<KtAnnotationEntry, String, String, String>()
    val PROVIDED_RUNTIME_TOO_LOW by error3<KtAnnotationEntry, String, String, String>()

    val INCONSISTENT_INHERITABLE_SERIALINFO by error2<PsiElement, ConeKotlinType, ConeKotlinType>()

    val EXTERNAL_CLASS_NOT_SERIALIZABLE by error2<PsiElement, FirClassSymbol<*>, ConeKotlinType>()
    val EXTERNAL_CLASS_IN_ANOTHER_MODULE by error2<PsiElement, FirClassSymbol<*>, ConeKotlinType>()
}

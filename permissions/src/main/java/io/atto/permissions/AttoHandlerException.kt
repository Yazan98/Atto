package io.atto.permissions

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:48 PM
 */

class AttoHandlerException : Exception(
    """
    Atto Permission Handler Is Not Provided
    You Should Provide The Handler Before Use This Operation
""".trimIndent()
)
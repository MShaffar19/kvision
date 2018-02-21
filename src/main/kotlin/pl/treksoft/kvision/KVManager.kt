/*
 * Copyright (c) 2017-present Robert Jaros
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package pl.treksoft.kvision

import com.github.snabbdom.Snabbdom
import com.github.snabbdom.VNode
import com.github.snabbdom.attributesModule
import com.github.snabbdom.classModule
import com.github.snabbdom.datasetModule
import com.github.snabbdom.eventListenersModule
import com.github.snabbdom.propsModule
import com.github.snabbdom.styleModule
import kotlin.browser.document
import kotlin.dom.clear

/**
 * @suppress
 * External function for loading CommonJS modules.
 */
external fun require(name: String): dynamic

/**
 * Internal singleton object which initializes and configures KVision framework.
 */
@Suppress("EmptyCatchBlock")
internal object KVManager {
    internal const val AJAX_REQUEST_DELAY = 300
    internal const val KVNULL = "#kvnull"

    private val bootstrapWebpack = try {
        require("bootstrap-webpack")
    } catch (e: Throwable) {
    }
    private val fontAwesomeWebpack = try {
        require("font-awesome-webpack")
    } catch (e: Throwable) {
    }
    private val awesomeBootstrapCheckbox = try {
        require("awesome-bootstrap-checkbox")
    } catch (e: Throwable) {
    }
    private val bootstrapSelectCss = try {
        require("bootstrap-select/dist/css/bootstrap-select.min.css")
    } catch (e: Throwable) {
    }
    private val bootstrapSelect = try {
        require("bootstrap-select/dist/js/bootstrap-select.min.js")
    } catch (e: Throwable) {
    }
    private val bootstrapSelectI18n = try {
        require("./js/bootstrap-select-i18n.min.js")
    } catch (e: Throwable) {
    }
    private val bootstrapSelectAjaxCss = try {
        require("ajax-bootstrap-select/dist/css/ajax-bootstrap-select.min.css")
    } catch (e: Throwable) {
    }
    private val bootstrapSelectAjax = try {
        require("ajax-bootstrap-select/dist/js/ajax-bootstrap-select.min.js")
    } catch (e: Throwable) {
    }
    private val trixCss = try {
        require("trix/dist/trix.css")
    } catch (e: Throwable) {
    }
    private val trix = try {
        require("trix")
    } catch (e: Throwable) {
    }
    private val bootstrapDateTimePickerCss = try {
        require("bootstrap-datetime-picker/css/bootstrap-datetimepicker.min.css")
    } catch (e: Throwable) {
    }
    private val bootstrapDateTimePicker = try {
        require("bootstrap-datetime-picker/js/bootstrap-datetimepicker.min.js")
    } catch (e: Throwable) {
    }
    private val bootstrapTouchspinCss = try {
        require("bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.css")
    } catch (e: Throwable) {
    }
    private val bootstrapTouchspin = try {
        require("bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js")
    } catch (e: Throwable) {
    }

    private val resizable = require("jquery-resizable-dom")
    internal val fecha = require("fecha")
    private val sdPatch = Snabbdom.init(
        arrayOf(
            classModule, attributesModule, propsModule, styleModule,
            eventListenersModule, datasetModule
        )
    )
    private val sdVirtualize = require("snabbdom-virtualize/strings").default
    private val styleCss = require("./css/style.css")

    internal fun patch(id: String, vnode: VNode): VNode {
        val container = document.getElementById(id)
        container?.clear()
        return sdPatch(container, vnode)
    }

    internal fun patch(oldVNode: VNode, newVNode: VNode): VNode {
        return sdPatch(oldVNode, newVNode)
    }

    @Suppress("UnsafeCastFromDynamic")
    internal fun virtualize(html: String): VNode {
        return sdVirtualize(html)
    }
}

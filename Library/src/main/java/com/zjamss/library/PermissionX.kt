package com.zjamss.library

import androidx.fragment.app.FragmentActivity

/**
 * @Program: GlobalUtil
 * @Description:
 * @Author: ZJamss
 * @Create: 2022-02-16 14:35
 **/
object PermissionX {
    private const val TAG = "InvisibleFragment"

    fun request(activity :FragmentActivity,vararg permissions:String,callback:PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if(existedFragment != null){
            existedFragment as InvisibleFragment
        }else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment,TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)  //*将一个数组转换成可变长度参数传递
    }
}
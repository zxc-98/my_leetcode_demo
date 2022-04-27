package cn.zxc.Demo12Tree;

import java.util.HashMap;
import java.util.Map;

public class PathSum_437 {

    public int pathSum_1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = dfs_1(root, targetSum) + pathSum_1(root.left, targetSum) + pathSum_1(root.right, targetSum);//检查自身树节点的情况和子节点的情况

        return ret;
    }

    private int dfs_1(TreeNode root, int targetSum) {//以当前节点开始遍历
        if (root == null) {
            return 0;
        }

        int count = 0;

        if (root.val == targetSum) {
            count++;
        }

        count += dfs_1(root.left, targetSum - root.val) + dfs_1(root.right, targetSum - root.val);
        return count;
    }


    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }

        // key是前缀和 value是对应的值
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        return dfs(root, targetSum, 0, map);
    }

    private int dfs(TreeNode root, int targetSum, int  sum, Map<Integer, Integer> map) {
        if(root == null) {
            return 0;
        }

        //当前路径上的和
        sum += root.val;
        //
        int curRes = map.getOrDefault(sum - targetSum, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        curRes +=  dfs(root.left, targetSum, sum, map);
        curRes +=  dfs(root.right, targetSum, sum, map);
        map.put(sum, map.get(sum) - 1);

        return curRes;
    }
}

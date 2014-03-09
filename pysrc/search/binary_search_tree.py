class TreeNode(object):
    def __init__(self, data):
        self.data = data
        self.lc = None
        self.rc = None

    def get_data(self):
        return self.data

    def set_rc(self, c):
        self.rc = c

    def set_lc(self, c):
        self.lc = c


class BinaryTree(object):
    """Binary tree implementation"""

    def __init__(self):
        self.root = None

    # public
    def insert(self, data):
        node = TreeNode(data)

        if self.root is None:
            self.root = node
            return

        next_node = self.root
        while True:
            if (node.data > next_node.data):
                if next_node.rc is None:
                    next_node.rc = node
                    break
                else:
                    next_node = next_node.rc

            if (node.data < next_node.data):
                if next_node.lc is None:
                    next_node.lc = node
                    break
                else:
                    next_node = next_node.lc

    # public
    def fetch_bfs(self, data):
        next_node = self.root


if __name__ == "__main__":
    x = [6, 3, 1, 9, 12, 4]
    b_tree = BinaryTree()
    for item in x:
        if item == 3:
            x = 5
        b_tree.insert(item)

        

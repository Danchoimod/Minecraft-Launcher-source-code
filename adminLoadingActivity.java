linear1.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View _view) {
        // Hiển thị hộp thoại xác nhận
        new AlertDialog.Builder(JavacodeActivity.this)
            .setTitle("Remove: " + _data.get(_position).get("key").toString())
            .setMessage("Are you sure you want to delete this item?")
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Kiểm tra nếu vị trí hợp lệ
                    if (_position >= 0 && _position < maplist.size()) {
                        // Xóa dữ liệu trên Firebase
                        code.child(project_str.get(_position)).removeValue()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        // Xóa khỏi danh sách
                                        maplist.remove(_position);
                                        
                                        // Cập nhật giao diện
                                        ((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
                                        SketchwareUtil.showMessage(getApplicationContext(), "Delete Successful");
                                    } else {
                                        SketchwareUtil.showMessage(getApplicationContext(), "Delete Failed");
                                    }
                                }
                            });
                    } else {
                        SketchwareUtil.showMessage(getApplicationContext(), "Invalid position");
                    }
                }
            })
            .setNegativeButton("No", null)
            .create()
            .show();

        return true;
    }
});
